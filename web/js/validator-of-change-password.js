function validateChangePassword(form) {
	if(form["new-password"].value != form["confirm-password"].value) {
		errorMessage(form["new-password"], "Ошибка при повторном наборе нового пароля");
		return false;
	}
	return true;
}
