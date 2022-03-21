
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Email</title>
<style>
		body{
        	display: flex;
            justify-content: center;
            align-content: center;
        }
        form{
            border: 2px solid black;
            width: fit-content;
            position: absolute;
            /*top:20%;
            left:30%;*/
            padding: 30px;
            box-shadow: 0.2em 0.2em 2em 0em grey;
        }
        input,textarea{
            width: 500px;
            line-height: 2em;
            display: block;
            margin-bottom:20px;
        }
        textarea{
            line-height: 5em;
            width: 300px;

        }
        input[type="submit"]
        {
            color: black;
            background: green;
            width: 150px;
        }
    </style>

</head>
<body>

<form:form method="post" action="http://localhost:8080/EmailSender/email" modelAttribute="email">
<form:input path="email" type="email" placeholder="email" ></form:input>
<form:input path="password" type="password" placeholder="password" ></form:input>
<form:input path="to" type="text" placeholder="to" ></form:input>
<form:input path="subject" placeholder="subject" type="text"></form:input>
<form:textarea path="body" placeholder="body"></form:textarea>
<form:button>send</form:button>
</form:form>
</body>
</html>