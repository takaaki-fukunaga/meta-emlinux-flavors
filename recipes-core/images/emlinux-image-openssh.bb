#
# OpenSSH server Linux image
#   based on EMLinux base image
#
# SPDX-License-Identifier: MIT
#

require recipes-core/images/emlinux-image-base.bb

DESCRIPTION = "OpenSSH server target root filesystem"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${LAYERDIR_core}/licenses/COPYING.MIT;md5=838c366f69b72c5df05c96dff79b35f2"

#
# Install recipes or self-build packages
#
IMAGE_INSTALL:append = " \
    sshd-regen-keys \
"

#
# Install Debian packages
#
IMAGE_PREINSTALL:append = " \
    connman \
    openssh-server \
"

#
# Add user for SSH access
#
USERS += "emlinux"
USER_emlinux[password] = "emlinux"
USER_emlinux[flags] = "create-home clear-text-password"
USER_emlinux[home] = "/home/emlinux"
USER_emlinux[shell] = "/bin/bash"
