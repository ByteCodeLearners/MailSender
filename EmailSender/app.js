const createError = require('http-errors');
const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const nodemailer=require('nodemailer');


//fill up your data

const to="";
const text="";
const subject="";
const gmail="";
// if 2 way authentication is enabled then follow these steps for app specific password and use it
// My Account> Sign-in > App Passwords
const password="";






//now start the app with 'npm run start' in the terminal

const app = express();
// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'hbs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));



app.get("/",async (req,res)=>
{
  let mailOption={
    from:gmail,
    to:to,
    text:text,
    subject:subject
  };
  await nodemailer.createTransport({
    host:"gmail",
    service:'gmail',
    auth:{
      user:gmail,
      pass:password
    }
  }).sendMail(mailOption)
      .then(success=>
      {
        console .log("sent",success);
        return res.send({status:"sent",statuscode:200,data:mailOption});
      })
      .catch(error=>
      {
        return res.send({status:"not sent",statuscode:400,stacktrace:error});
      });
});





app.get("/show",(req,res)=>
{
  return res.render("sendMail")
})



app.post("/send",async (req,res)=>
{
  let mailOption={
  from:req.body.email,
  to:req.body.to,
  text:req.body.body,
  subject:req.body.subject
};
  await nodemailer.createTransport({
    host:"gmail",
    service:'gmail',
    auth:{
      user:mailOption.from,
      pass:req.body.password
    }
  }).sendMail(mailOption)
      .then(success=>
      {
        console .log("sent",success);
        return res.render("SentStatus",{sentStatus:"sent",data:JSON.stringify(mailOption)});
      })
      .catch(error=>
      {

        console .log("not sent",error);
        return res.render("SentStatus",{sentStatus:"not sent",stacktrace:JSON.stringify(error)});
      });
})



// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});













module.exports = app;
