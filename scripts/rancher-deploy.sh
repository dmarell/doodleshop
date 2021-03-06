#!/bin/bash
# rancher-deploy.sh environment directory
# Requires the following env
#  export RANCHER_URL=http://54.194.13.146:8080/
#  export RANCHER_ACCESS_KEY=0BFCA269BC85B803B083
#  export RANCHER_SECRET_KEY=b7T82WRcRuopiTxbsUV31ETTACu1Fh4QGnktbmbj

set -e
if (( $# != 2))
then
    echo "Usage: $0 <rancherenv> <directory>"
    exit 1
fi
export RANCHER_ENVIRONMENT=$1
cd directory
# Upgrade
rancher up -u -d
# Confirm (remove old containers)
rancher up -c -d
cd -