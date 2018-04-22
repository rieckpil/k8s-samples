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