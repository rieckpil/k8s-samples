# Kubernetes Samples

## Kubernetes commands

```
kubectl version
kubectl logs podName
kubectl explain pods
kubectl create -f fileName.yml
kubectl get pods --namespace=kube-system
kubectl logs name -c containerName
kubectl describe pods podName
kubectl get rc
kubectl edit rc nginx
kubectl delete rc nginx
kubectl run nginx --image=nginx:1.12.0 --replicas=2 --port=80
kubectl expose deployment nginx --port=80 --target-port=80
kubectl replace -f nginxDeployment.yml
kubectl apply -f nginxDeployment.yml
kubectl set image deployment nginx nginx=nginx:1.13.1
kubectl get endpoints
kubectl create secret generic mypassword --from-file=secrets/myverysecurepassword.txt
kubectl create secret generic mypassword2 --from-literal=password=123456
echo "aGVsbG9Xb3JsZA==" | base64 --decode
kubectl create configmap example --from-file=configs/application.properties
kubectl edit configmap example
kubectl top node
kubectl top pod besteffort
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml
kubectl describe --namespace=kube-system pod kubernetes-dashboard-5bd6f767c7-mfxs
kubectl cluster-info
kubectl delete --all pods --namespace=monitoring
```

General spec:

```yml
apiVersion: Kubernetes API version
kind: object type
metadata: 
  spec metadata, i.e. namespace, name, labels and annotations
spec: 
  the spec of Kubernetes object

```

# Certified Kubernetes Application Developer

* check readiness

```bash
wget http://bit.ly/LFready -O ready-for.sh
chmod 755 ready-for.sh
./ready-for.sh LFD420
./ready-for.sh --install LFD420
```

* add scripts

```bash
 wget https://training.linuxfoundation.org/cm/LFD259/LFD259_V2019-03-11_SOLUTIONS.tar.bz2 \
--user=XXX --password=XXX
tar -xvf LFD259 V2019-03-11 SOLUTIONS.tar.bz2
```

* update install step:

```bash
sudo apt-get update
sudo apt-get install -y kubernetes-cni=0.6.0-00
sudo apt-get install -y kubeadm=1.13.1-00 kubelet=1.13.1-00 kubectl=1.13.1-00
```

## Processes within a node

* **kubelet** receives requests to run the containers, manages any necassary resources and watches over them on the local node. It accepts pod specifications `PodSpecs` to configure the local node. It will also ensure the access or creation of storage, config maps or secrets if needed
* **kube-proxy** creates and manages networkng rules to expose the container on the network

----

* **pod** consists of one ore more containers which share an IP address, access to storage and namespace
* **ReplicaSet** is a controller which deploys and restarts containers until the requested number of containers is running

* parts of the master node: **kube-apiserver, kube-scheduler, etcd, cloud-controller-manager**

* **kube-apiserver** is central to the operation of the cluster. All calls, both internal and external traffic are handled via this agent. All actions are accepted and validated by this agent, and it is the only connection to the etcd database

* **kube-scheduler** uses an algorithm to determine which node will host a Pod of containers

* **etcd** a b+tree key-value store to store the state of the cluster. Values are always appended to the end and not updated