from django.shortcuts import render
from django.core.mail import send_mail
from django.conf import settings
# Create your views here.
def home(request):
    return render (request, 'index.html', {'title':'Homepage'})

def SendMail(request):
    if request.method == 'POST':
        to = request.POST.get('tomail')
        subject = request.POST.get('sub')
        content = request.POST.get('content')
        # print(to, content)
        send_mail(
            #subject
            subject,
            #message
            content,
            #from email
            settings.EMAIL_HOST_USER,
            #reciept list
            [to]
        )
        return render(
        request,
        'thanks.html',
        {
            'title':'Thanks....'
        }
    )

    else:
        return render(
        request,
        'email.html',
        {
            'title':'MailSender'
        }
    )
