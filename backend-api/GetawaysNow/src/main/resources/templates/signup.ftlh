<!doctype html>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link rel="stylesheet" href="/style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex flex-column align-items-center" style="padding-top: 20px; min-height: 150vh;">

    <a href="/" class="text-center">
        <img src="/images/Logo.jpg" style="width: 300px; margin-bottom: 150px;">
    </a>

    <div class="card shadow" style="width: 900px;">
        <div class="card-header text-center" style="background-color: #88b6c8;">
            <h3 class="mb-0 text-white">Sign Up</h3>
        </div>

        <div class="card-body p-4">

            <#if error??>
                <div class="alert alert-danger text-center" role="alert">
                    ${error}
                </div>
            </#if>

            <form action="/signup" method="post">

                <div class="mb-3 row">
                    <label for="inputUsername" class="col-sm-3 col-form-label">Username/Email:</label>
                    <div class="col-sm-9"> <input type="text" 
                               name="username" 
                               id="inputUsername" 
                               class="form-control" 
                               required />
                    </div>
                </div>

                <div class="mb-3 row align-items-center">
                    <label for="inputPassword" class="col-sm-3 col-form-label">Password:</label>
                    <div class="col-sm-9">
                        <input type="password" 
                               name="password" 
                               id="inputPassword" 
                               class="form-control" 
                               maxlength="26" 
                               required>
                    </div>
                </div>

                <div class="mb-3 row align-items-center">
                    <label for="confirmPassword" class="col-sm-3 col-form-label">Confirm Password:</label>
                    <div class="col-sm-9 d-flex align-items-center">
                        <input type="password" 
                               name="confirmPassword" 
                               id="confirmPassword" 
                               class="form-control me-2" 
                               maxlength="26" 
                               required>
                        
                        <div class="form-check mb-0" style="min-width: 70px;">
                            <input type="checkbox" class="form-check-input" onclick="togglePassword()" id="showPassword">
                            <label class="form-check-label" for="showPassword">Show</label>
                        </div>
                    </div>
                </div>

                <div class="mt-4 text-center"> <button type="submit" class="btn w-50"
                            style="background-color: hsl(216, 100%, 50%); color: white;">
                        Create Account
                    </button>
                </div>

                <div class="mb-3 mt-3 text-center">
                    Already have an account?
                    <a href="/login" class="ms-1">Log in</a>
                </div>

            </form>
        </div>
    </div>


    <script src="scripting/showPassword.js"></script>
    <script src="scripting/login_signup_field_validation.js"></script>
</body>

</html>