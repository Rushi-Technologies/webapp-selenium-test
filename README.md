# Java Selenium URL Test (Multi-Environment Support)

This test uses Selenium and JUnit to verify if a given URL loads and its title contains "Example Domain". It uses WebDriverManager to auto-download `chromedriver`.

## ✅ Usage

### Run with Maven and System Property

```bash
mvn test -DTEST_URL=http://13.56.184.225:8080/student-reg-webapp/
```

# Run tests with URL from env
mvn test -DTEST_URL=$TEST_URL
```

## 🚀 Jenkins Integration
### Install  Chrome binary in Jenikins System/Agent
```bash
sudo yum install -y wget
wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
sudo yum install -y ./google-chrome-stable_current_x86_64.rpm
google-chrome --version
```

The `Jenkinsfile` includes:
- Running tests with dynamic URL (`$TEST_URL`)
- Failing build on test failure
- Publishing JUnit test reports
