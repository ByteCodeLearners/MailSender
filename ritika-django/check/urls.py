from django.urls import path
from . import views

urlpatterns = [
     path("", views.contact_send_mail, name='Email_sender'),
     path("Email_sender", views.contact_send_mail, name='Email_sender'),

]