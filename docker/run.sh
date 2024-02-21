#!/usr/bin/env bash

# login or use cached credentials
set -x

podman-compose -f docker-compose.yaml down
podman-compose -f docker-compose.yaml up -d --remove-orphans

set +x
