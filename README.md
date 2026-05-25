# Ford Blue/Green App

E-commerce application demonstrating **Blue/Green Deployment** strategy with **Instana APM** monitoring.

## 🚀 Quick Start

### Prerequisites
- Kubernetes cluster
- ArgoCD installed
- Instana account (Agent Key and EUM Key)

### Installation

```bash
# Clone the repository
git clone https://github.com/irfadkp/ford-bluegreen-app.git
cd ford-bluegreen-app

# Set Instana credentials as environment variables
export INSTANA_AGENT_KEY="your-agent-key"
export INSTANA_EUM_KEY="your-eum-key"

# Run the installer
chmod +x install.sh
./install.sh
```

For detailed installation instructions, see [INSTALL.md](INSTALL.md).

## 📋 Architecture

### Components
- **Backend** (Node.js): REST API with Instana Node.js agent
- **Frontend** (React + Vite): SPA with Instana EUM
- **PostgreSQL**: Database

### Deployment Strategy
**Blue/Green Deployment**: Zero-downtime deployments with instant traffic switch
- **Blue Environment**: Current production version
- **Green Environment**: New version being deployed and tested
- **Traffic Switch**: Instant cutover from blue to green after validation
- **Rollback**: Quick rollback to blue if issues detected

## 🔐 Security - Instana Keys

**IMPORTANT**: Instana keys are **NEVER** committed to Git.

- Keys are stored as **Kubernetes Secrets**
- `.env` file is in `.gitignore`
- Use environment variables or secret management tools
- Secrets are created by `install.sh` script

### Secrets Created
- `backend-ford-instana-secret`
- `frontend-ford-instana-secret`

## 📊 Monitoring with Instana

### Backend Monitoring
- Node.js agent automatically instruments the application
- Traces HTTP requests, database queries, and external calls
- Custom spans using Instana SDK

### Frontend Monitoring
- End User Monitoring (EUM) tracks:
  - Page load times
  - User interactions
  - JavaScript errors
  - AJAX calls

## 🛠️ Development

### Local Development
```bash
# Backend
cd backend
npm install
npm run dev

# Frontend
cd frontend
npm install
npm run dev
```

### Building Images
Images are automatically built and pushed by GitHub Actions on push to `master` branch.

## 📦 CI/CD Pipeline

GitHub Actions workflow:
1. Detects changes in backend or frontend
2. Builds Docker images
3. Pushes to GitHub Container Registry (GHCR)
4. Updates image tags in GitOps manifests
5. ArgoCD automatically syncs changes

## 🔄 GitOps Structure

```
gitops/
├── argocd/
│   └── application.yaml    # ArgoCD Application definition
├── base/                   # Base Kubernetes manifests
└── overlays/
    └── dev/               # Dev environment overlays
```

## 📖 Documentation

- [Installation Guide](INSTALL.md)
- [Architecture Details](ARCHITECTURE.md)
- [Implementation Guide](IMPLEMENTATION_GUIDE.md)
- [Quick Start](QUICKSTART.md)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test locally
5. Submit a pull request

## 📝 License

MIT License

## 🆘 Support

For issues:
- Check [INSTALL.md](INSTALL.md) troubleshooting section
- Review ArgoCD application logs
- Verify Instana agent is running
- Check GitHub Actions workflow logs