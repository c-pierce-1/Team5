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
            <h3 class="mb-0 text-white">Login</h3>
        </div>

        <div class="card-body p-4">

            <#-- ERROR MESSAGE FROM CONTROLLER -->
            <#if error??>
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            </#if>

            <form action="/login" method="post">

                <#if error??>
                    <div class="alert alert-danger text-center">
                        ${error}
                    </div>
                </#if>


                <!-- Username -->
                <div class="mb-3 row">
                    <label for="inputUsername" class="col-sm-2 col-form-label">Username/Email:</label>
                    <div class="col-sm-3">
                        <input type="text"
                               name="username"
                               id="inputUsername"
                               class="form-control"
                               required />
                    </div>
                </div>

                <!-- Password -->
                <div class="mb-3 row align-items-center">
                    <label for="inputPassword" class="col-sm-2 col-form-label">Password:</label>
                    <div class="col-sm-4 d-flex align-items-center">
                        <input type="password"
                               name="password"
                               id="inputPassword"
                               class="form-control me-2"
                               maxlength="26"
                               required >
                        <div class="form-check mb-0">
                            <input type="checkbox" class="form-check-input" onclick="togglePassword()" id="showPassword">
                            <label class="form-check-label" for="showPassword">Show</label>
                        </div>
                    </div>
                </div>

                <div class="mt-4">
                    <button type="submit" class="btn w-1"
                            style="background-color: hsl(216, 100%, 50%); color: white;">
                        Log in
                    </button>
                </div>

                <div class="mb-3">
                    Don't have an account?
                    <a href="/signup" class="ms-1">Sign up</a>
                </div>

            </form>
        </div>
    </div>

    <script>
        function togglePassword() {
            const x = document.getElementById("inputPassword");
            x.type = x.type === "password" ? "text" : "password";
        }
    </script>

</body>

</html>
