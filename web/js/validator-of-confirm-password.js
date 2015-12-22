function validateChangePassword(form) {
	if(form["password"].value != form["confpassword"].value) {
		errorMessage(form["password"], "Ошибка при повторном наборе нового пароля");
		return false;
	}
	return true;
}
