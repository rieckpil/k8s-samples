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