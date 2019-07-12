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

## Core Concepts 13%

```shell
kubectl create namespace nginx
kubectl run nginx --image=nginx  -n mynamespace
kubectl delete --all deploy -n=nginx

kubectl run nginx --image=nginx -n=nginx --dry-run -o yaml > nginx.yaml
kubectl create -f nginx.yaml -n nginx

kubectl run busybox --image=busybox --restart=Never --dry-run -o yaml --command  -- env > envpod.yaml
kubectl apply -f envpod.yaml
kubectl logs busybox

kubectl create namespace myns --dry-run -o yaml

kubectl create quota myrq --hard=cpu=1,memory=1G,pods=2 --dry-run -o yaml

kubectl get po --all-namespaces
```


## Configuration 18%


```shell

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


## State Persistence 8%