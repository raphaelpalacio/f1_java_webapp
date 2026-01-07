# Environment Setup Guide

## Quick Start

### 1. Create a Supabase Project

1. Go to [supabase.com](https://supabase.com) and create an account
2. Click "New Project"
3. Choose a name and set a database password (save this!)
4. Wait for the project to be created (~2 minutes)

### 2. Get Your Connection String

1. Go to **Project Settings** (gear icon)
2. Click **Database** in the left sidebar
3. Scroll to **Connection string**
4. Click **JDBC** tab
5. Copy the connection string

It looks like this:
```
jdbc:postgresql://db.abcdefghijk.supabase.co:5432/postgres
```

### 3. Set Environment Variables

#### Option A: Export in Terminal (Quick)

```bash
export SUPABASE_DB_URL="jdbc:postgresql://db.YOUR_PROJECT_REF.supabase.co:5432/postgres"
export SUPABASE_DB_USER="postgres"
export SUPABASE_DB_PASSWORD="your_password_here"
```

Then run:
```bash
mvn spring-boot:run
```

#### Option B: Create Local Properties File (Persistent)

Create `src/main/resources/application-local.properties`:

```properties
spring.datasource.url=jdbc:postgresql://db.YOUR_PROJECT_REF.supabase.co:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=your_password_here
```

Then run with the local profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

#### Option C: IntelliJ/IDE Run Configuration

1. Edit your run configuration
2. Add environment variables:
   - `SUPABASE_DB_URL`
   - `SUPABASE_DB_USER`
   - `SUPABASE_DB_PASSWORD`

### 4. Verify Connection

Run the app:
```bash
mvn spring-boot:run
```

Look for this in the console:
```
============================================
✅ DATABASE CONNECTION SUCCESSFUL!
   Connected to: jdbc:postgresql://db.xxx.supabase.co:5432/postgres
============================================
```

If you see an error, double-check:
- [ ] Project ref is correct in the URL
- [ ] Password is correct
- [ ] No extra spaces in the values

### 5. Check Supabase Dashboard

After successful connection:
1. Go to your Supabase project
2. Click **Table Editor** in the left sidebar
3. You should see these tables auto-created:
   - `users`
   - `user_predictions`
   - `drivers`
   - `constructors`
   - `circuits`
   - `races`
   - `race_results`

---

## Troubleshooting

### "Connection refused"
- Check if the URL is correct
- Make sure you're using port `5432`

### "Password authentication failed"
- Double-check your database password
- It's the password you set when creating the project (not your Supabase account password)

### "SSL required"
Add this to your URL:
```
jdbc:postgresql://db.xxx.supabase.co:5432/postgres?sslmode=require
```

### Tables not created
Check that `spring.jpa.hibernate.ddl-auto=update` is in your properties.

---

## Environment Variables Reference

| Variable | Required | Description |
|----------|----------|-------------|
| `SUPABASE_DB_URL` | ✅ | JDBC connection string |
| `SUPABASE_DB_USER` | ✅ | Usually `postgres` |
| `SUPABASE_DB_PASSWORD` | ✅ | Your database password |
| `OPENAI_API_KEY` | ❌ | For AI features (later) |
| `JWT_SECRET` | ❌ | For auth (later) |

