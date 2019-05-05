# Spring boot aws With Jenkins in AWS


## Steps to deploy oracle to aws 

    yum install wget
    wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-x64.rpm
    yum install -y jdk-8u141-linux-x64.rpm
    
## Steps to deploy Jenkins

    Check the link below for Installation of Jenkins
    
    https://docs.aws.amazon.com/aws-technical-content/latest/jenkins-on-aws/installation.html
  
## Configure Apache 
    
    yum install httpd.
    
    go to the folder
        
       /etc/httpd/conf
       
       add the below to httd.conf file using vi editor, this is to use jenkins on port 80
       
       <VirtualHost *:80>
               Servername <<dns name of Jenkins>>
               ProxyRequests Off
               ProxyPreserveHost On
               AllowEncodedSlashes NoDecode
               ProxyPass / http://localhost:8080/ nocanon
               ProxyPassReverse / http://localhost:8080/
               ProxyPassReverse / http://<<dnsname of jenkins>>
               <Proxy http://localhost:8080/* >
                       Order deny,allow
                       Allow from all
               </Proxy>
       </VirtualHost>
       
       use command , 
       service httpd restart 
       to restart the server
       
       go to folder, the below configuration is to stop jenkins using the port 8080
       
       /etc/sysconfig
       
       modify the jenkins file in vi editor
       
       modify JENKINS_LISTEN_ADDRESS="" to JENKINS_LISTEN_ADDRESS="127.0.0.1"
       
       use command.
       service jenkins restart
       
       to restart jenkins
       
       once you try using jenkins on port 8080, the service will be unavailable
       
       but it will be available on port 80
       

## install git

    yum install git
    
## Creating ssh keys

    sudo su
    cd /etc/sysconfig
    su -s /bin/bash jenkins
    
    
    cd /var/lib/jenkins
    mkdir .ssh
    cd .ssh
    
    ssh-keygen -t rsa -C 'jenkin@example.com'