#!/usr/bin/python3

"""
The script is used to copy the compiled jars to this project.
"""
import argparse
import glob
import re
import shutil
from pathlib import Path

fmt_version = "([\\d.]+)"
fmt_jar_ext = "\\.jar"
match_regex_list = {
    "core": f"^jhove-core-{fmt_version}{fmt_jar_ext}",
    "ext-modules": f"^jhove-ext-modules-{fmt_version}{fmt_jar_ext}",
    "aiff": f"^aiff-hul-{fmt_version}{fmt_jar_ext}",
    "ascii": f"^ascii-hul-{fmt_version}{fmt_jar_ext}",
    "gif": f"^gif-hul-{fmt_version}{fmt_jar_ext}",
    "html": f"^html-hul-{fmt_version}{fmt_jar_ext}",
    "jpeg2000": f"^jpeg2000-hul-{fmt_version}{fmt_jar_ext}",
    "jpeg": f"^jpeg-hul-{fmt_version}{fmt_jar_ext}",
    "pdf": f"^pdf-hul-{fmt_version}{fmt_jar_ext}",
    "tiff": f"^tiff-hul-{fmt_version}{fmt_jar_ext}",
    "utf8": f"^utf8-hul-{fmt_version}{fmt_jar_ext}",
    "wave": f"^wave-hul-{fmt_version}{fmt_jar_ext}",
    "xml": f"^xml-hul-{fmt_version}{fmt_jar_ext}",
}


class JarFilePair:
    def __init__(self, new_path, old_path):
        self.new_path = new_path
        self.old_path = old_path

    def get_path_pair(self):
        return self.new_path, self.old_path


def get_matched_jar(jars, regex):
    for jar_path in jars:
        jar_name = Path(jar_path).name
        matched_file_name = re.findall(regex, jar_name)
        if matched_file_name is not None and len(matched_file_name) > 0:
            return jar_path
    return None


def get_dual_matched_jars(new_jars, old_jars):
    results = {}
    for key in match_regex_list:
        regex = match_regex_list[key]
        new_jar_path = get_matched_jar(new_jars, regex)
        old_jar_path = get_matched_jar(old_jars, regex)
        jar_pair = JarFilePair(new_jar_path, old_jar_path)
        results[key] = jar_pair
    return results


def pickup_jhove_jars(jhove_path, curr_lib_path):
    new_jars = [Path(p).resolve() for p in glob.iglob(str(jhove_path) + "/**/target/*.jar", recursive=True)]
    old_jars = [Path(p).resolve() for p in glob.iglob(str(curr_lib_path) + "/**/*.jar", recursive=True)]
    matched_results = get_dual_matched_jars(new_jars, old_jars)
    flag_valid = True
    for key in matched_results:
        jar_pair = matched_results[key]
        new_jar_path, old_jar_path = jar_pair.get_path_pair()

        if new_jar_path is None:
            print(f"[ERROR] {key}: Not able to find the new jar library.")
            flag_valid = False
            continue
        else:
            print(f"[INFO] {key}: Found the new jar library: {new_jar_path}")

        if old_jar_path is None:
            print(f"[INFO] {key}: The old jar library does not exist.")
        else:
            print(f"[INFO] {key}: Found the old jar library: {old_jar_path}, which will be replaced")

    if not flag_valid:
        print(f"[WARNING] Will not process because not all new jars can be found.")
        return

    # Delete the old jars
    for key in matched_results:
        jar_pair = matched_results[key]
        _, old_jar_path = jar_pair.get_path_pair()
        if old_jar_path is None:
            continue
        Path(old_jar_path).unlink(missing_ok=True)
        print(f"[INFO] Deleted: {old_jar_path}")

    # Copy the new jars
    for key in matched_results:
        jar_pair = matched_results[key]
        new_jar_path, _ = jar_pair.get_path_pair()
        target_jar_path = Path(curr_lib_path, Path(new_jar_path).name)
        shutil.copyfile(str(new_jar_path), str(target_jar_path))
        print(f"[INFO] Copied: {new_jar_path} -> {target_jar_path}")


if __name__ == "__main__":
    # construct the argument parser and parse the arguments
    parser = argparse.ArgumentParser()
    parser.add_argument("-v", "--source", required=True, default=0,
                        help="The directory of the jhove project. Where the latest jar files will be found.")

    args = parser.parse_args()

    path_curr = Path(__file__).parent
    lib_path = path_curr.joinpath("lib")

    pickup_jhove_jars(args.source, lib_path)
