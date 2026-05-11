# Ford Blue/Green Deployment Demo

A demonstration application showcasing Blue/Green deployment strategy with intentional errors and heavy logging for monitoring purposes.

## Architecture

- **Backend**: Java Spring Boot application with REST API
- **Frontend**: React application with modern UI
- **Database**: PostgreSQL
- **Deployment**: Blue/Green strategy using Argo Rollouts
- **Monitoring**: Instana APM integration

## Features

- ✅ Intentional error generation (20-40% failure rate)
- ✅ Heavy logging for monitoring
- ✅ External API calls for network traffic
- ✅ Background scheduled tasks
- ✅ Blue/Green deployment with manual promotion
- ✅ Health checks and probes
- ✅ Instana monitoring integration

## Vehicle Models

- F-150 (Truck)
- Mustang (Sports)
- Explorer (SUV)
- Bronco (SUV)
- Ranger (Truck)

## Quick Start

### Prerequisites

- Kubernetes cluster
- ArgoCD installed
- Argo Rollouts installed
- GitHub account for CI/CD

### Deployment

1. **Create namespace**:
```bash
kubectl create namespace ford-shop-dev
```

2. **Deploy with ArgoCD**:
```bash
kubectl apply -f gitops/argocd/application.yaml
```

3. **Access the application**:
- Frontend: http://ford-shop.local
- Backend API: http://ford-shop.local/api

### Local Development

**Backend**:
```bash
cd backend
mvn spring-boot:run
```

**Frontend**:
```bash
cd frontend
npm install
npm start
```

## CI/CD Pipeline

GitHub Actions automatically builds and pushes Docker images to GHCR on push to main/master branch.

## Monitoring

The application generates:
- Heavy application logs
- Intentional errors (20-40% rate)
- External API calls
- Background task logs
- Performance metrics

## Blue/Green Deployment

The backend uses Argo Rollouts with Blue/Green strategy:
- Preview environment for testing
- Manual promotion to production
- Automatic rollback on failure

## License

MIT
