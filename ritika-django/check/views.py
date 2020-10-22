# from django.shortcuts import render
from django.shortcuts import render, HttpResponse
from .forms import Contactform
from django.core.mail import send_mail
from django.conf import settings


def contact_send_mail(request):
    if request.method == "GET":
        form = Contactform()

    else:
        if request.method == "POST":
            form = Contactform(request.POST)
            if form.is_valid():
                message = request.POST['body']
                subject = request.POST['subject']
                send_mail(subject,
                          message,
                          settings.EMAIL_HOST_USER,
                          ["Receiver's email id"],
                          fail_silently=False,
                          )
    return render(request, 'mail_form.html', {'form': form})

# Create your views here.
