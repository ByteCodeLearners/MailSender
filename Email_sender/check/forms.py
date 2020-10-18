from django import forms


class Contactform(forms.Form):
    email = forms.EmailField()
    password = forms.CharField(max_length=11, widget=forms.PasswordInput)
    send_to = forms.EmailField()
    subject = forms.CharField(max_length=25)
    body = forms.CharField(widget=forms.Textarea, required=True)