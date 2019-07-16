# Preparation for CKAD

* Six Kubernetes clusters are available during the exam with different setups

```shell
kubectl config use-context k8s
ssh k8s-node-0
sudo -i
```

* Train with: https://github.com/dgkanatsios/CKAD-exercises
* https://kubernetes.io/docs/tasks/administer-cluster/declare-network-policy/
* https://kubernetes.io/docs/concepts/cluster-administration/logging/
* https://kubernetes.io/docs/concepts/cluster-administration/logging/#sidecar-container-with-a-logging-agent

Good to know:

```shell
kubectl api-resources --namespaced=true

kubectl diff -f deployment.yaml
kubectl apply -f deployment.yaml
kubectl get pods -l environment=prod
kubectl get pods --field-selecter metadata.name=nginx
kubectl described node node-id
kubectl logs multiple-container -c first-container
kubectl get pods --show-labels

kubectl scale deployment.v1.apps/nginx --replicas=5

kubectl run curl --image=radial/busyboxplus:curl -i --tty

```

## Core Concepts 13%

* Kubernetes master node (one node in the cluster) runs the: kube-apiserver, kube-controller-manger (node controller, endpoint controller, replication controller, service acooutn & token controller)/cloud-controller-manager, kube-scheduler
* Every worker node runs the following two processes: kubelet (communicates with the master node, receives PodSpecs and make sure the pods are healthy & running), kube-proxy (network proxy, reflecting Kubernetes networking services on each node)
* Basic Kubernetes objects: Pod, Service, Namespace, Volume
* High-level abstraction objects (controllers) build upon the basic objects: ReplicaSet, Deployment, StatefulSet, DeamonSet, Job
* Kubernetes benefits: Service discovery and load balancing, storage orchestration, automated rollouts and rollbacks, automatic bin packing (CPU & MEM), Self-healing, secret and configuration management
* Container runtimes: Docker, containerd, cri-o, rktlet and any implementation of the Kubernetes CRI (container runtime interface)


```shell
kubectl create namespace nginx
kubectl run nginx --image=nginx  -n mynamespace
kubectl delete --all deploy -n=nginx

kubectl run nginx --image=nginx -n=nginx --dry-run -o yaml > nginx.yaml
kubectl create -f nginx.yaml -n nginx

kubectl run busybox --image=busybox --restart=Never --dry-run -o yaml --command -- env > envpod.yaml
kubectl apply -f envpod.yaml
kubectl logs busybox

kubectl create namespace myns --dry-run -o yaml

kubectl create quota myrq --hard=cpu=1,memory=1G,pods=2 --dry-run -o yaml

kubectl get po --all-namespaces

kubectl create deploy nginx --image=nginx --port=80
kubectl expose deploy nginx --port=80

kubectl set image pod/nginx nginx=nginx:1.7.1

kubectl run busybox --image=busybox --command --restart=Never -- wget 10.28.2.24:80/
kubectl run busybox --image=busybox -it --restart=Never -- sh


kubectl logs nginx -p

kubectl run busybox --image=busybox -it --rm --restart=Never -- /bin/sh -c 'echo hello world'

kubectl run --generator=run-pod/v1 nginx-2 --image=nginx --env "var=val1" -it -- sh

kubectl rollout history deployment.v1.apps/nginx
kubectl rollout history deployment.v1.apps/nginx --revision=1


```


## Configuration 18%

* 

```shell
kubectl create secret generic db-user-pass --from-file=./username.txt --from-file=./password.txt

```

## Multi-Container Pods 10%


```shell

```

## Observability 18%


```shell

```

## Pod Design 20%


```shell

```

## Services & Networking 13%

* ClusterIP is default
* Services can be created without pod selectors, to be able to manually assign endpoints to the service
* Proxying was used in favour of DNS
* DNS should be always setup as a cluster add-on
* ServiceTypes: ClusterIP, NodePort, LoadBalancer, ExternalName

```shell
kubectl expose deployment/nginx
kubectl get ep nginx
kubectl exec podname -- printenv | grep SERVICE

kubectl get netpol

```

```yaml
apiVersion: v1
kind: Service
metadata:
  name: my-service
spec:
  ports:
  - protocol: TCP
    port: 80
    targetPort: 9376
---
apiVersion: v1
kind: Endpoints
metadata:
  name: my-service
subsets:
  - addresses:
      - ip: 192.0.2.42
    ports:
      - port: 9376
```

## State Persistence 8%

*
*


```shell


```