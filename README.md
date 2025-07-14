# Java Selenium URL Test (Multi-Environment Support)

This test uses Selenium and JUnit to verify if a given URL loads and its title contains "Example Domain". It uses WebDriverManager to auto-download `chromedriver`.

## ✅ Usage

### Run with Maven and System Property

```bash
mvn test -DTEST_URL=https://example.com
```

### Run with Environment File (dev/test/prod)

```bash
# Load environment
source environments/dev.env

# Run tests with URL from env
mvn test -DTEST_URL=$TEST_URL
```

## 🚀 Jenkins Integration

The `Jenkinsfile` includes:
- Running tests with dynamic URL (`$TEST_URL`)
- Failing build on test failure
- Publishing JUnit test reports

## 📁 Environments

You can use one of these:
- `environments/dev.env`
- `environments/test.env`
- `environments/prod.env`
