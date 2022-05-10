#
# Copyright (c) Siemens AG, 2022
# Copyright (c) 2021, Mentor Graphics, a Siemens business
#
# Authors:
#  Felix Moessbauer <felix.moessbauer@siemens.com>
#
# This file is subject to the terms and conditions of the MIT License.
# See COPYING.MIT file in the top-level directory.
#
# Files below ./files are licensed under the Apache-2.0 license

inherit dpkg

# build this package for the buildchroot-host
PACKAGE_ARCH = "${HOST_ARCH}"
# we do not really cross-compile, but have to work in the buildchroot-host
ISAR_CROSS_COMPILE = "1"

PR = "1"

SRC_URI = "git://github.com/AsuraZeng/bazel.git;protocol=https;branch=${KERNEL_BRANCH}; \
           file://debian                                                                           "

KERNEL_BRANCH = "remove-4.2.2"
SRCREV = "692f56491151affe33bb5bfe44b635c16434efc1"

S = "${WORKDIR}/git"


do_prepare_build() {
    cp -r ${WORKDIR}/debian ${S}/
}
