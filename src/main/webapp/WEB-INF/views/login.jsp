<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="./Please sign in_files/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="./Please sign in_files/signin.css" rel="stylesheet" crossorigin="anonymous">
  </head>
  <body>
     <div class="container">
      <form class="form-signin" method="post" action="http://localhost:30001/bachelor/login">
        <h2 class="form-signin-heading">Please sign in</h2>
      <p>
          <label for="username" class="sr-only">학생 이름</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="username" required="" autofocus="">
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        </p>
		<input name="_csrf" name="${_csrf.parameterName}"value="${_csrf.token}"/>>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
</body></html>