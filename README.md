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

## Processes within a node

* **kubelet** receives requests to run the containers, manages any necassary resources and watches over them on the local node
* **kube-proxy** creates and manages networkng rules to expose the container on the network

* **pod** consists of one ore more containers which share an IP address, access to storage and namespace
* **ReplicaSet** is a controller which deploys and restarts containers until the requested number of containers is running

* parts of the master node: **kube-apiserver, kube-scheduler, etcd, cloud-controller-manager**