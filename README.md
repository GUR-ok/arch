Arch Homework

1) В корне проекта выполнить: helm install gorelov-arch-hw ./deployment/
2) curl http://arch.homework/health && curl http://arch.homework/otusapp/gur-ok/health
3) Для очистки пространтсва выполнить: helm uninstall gorelov-arch-hw

Важно!
- Убедиться, что в etc/hosts прописан адрес из команды minikube ip
192.168.59.100 arch.homework
- Проверить что в minikube есть ingress: minikube addons enable ingress
- Использовать nginx ingress controller установленный через хелм, а не встроенный в minikube:
  - kubectl create namespace m && helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/ && helm repo update && helm install nginx ingress-nginx/ingress-nginx --namespace m -f deployment/nginx-ingress.yaml
  - В случае ошибки установки выполнить: kubectl get ingressClass ,
  kubectl delete ingressClass nginx и повторить установку.