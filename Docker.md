# Installing docker on aws Red hat Linux

Step 1 :  Install the docker repository

    sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
    
    this will be saved in the location
    /etc/yum.repos.d/docker-ce.repo
    
    
    if we run the below command
    
     yum install -y docker-ce
     
     it will not get installed as it requires  container-selinux >= 2.9
     
Step 2 : Install  container-selinux >= 2.9

    sudo yum install -y ftp://bo.mirror.garr.it/1/slc/centos/7.1.1503/extras/x86_64/Packages/container-selinux-2.9-4.el7.noarch.rpm
    
    This will install conatiner-selinux engine which is required for docker engine install
    
Step 3 : Install Docker Community edition

    sudo yum install -y docker-ce
    
Step 4 : Start the Docker daemon service using the below command

    systemctl start docker.service
    
    we can stop the docker daemon service using the below command
    
    systemctl stop docker.service

Step 5 : to check the images running on the docker, we can use the below command

    docker image ls
    
Step 6 : to check the version of the docker

    docker --version
    
Step 7 : 