function validateBetFix(form) {
	if(!validateForm(form, [{
		id: "winamount",
		message: "Поле Выигрыш не заполнено",
		checker: checkNotEmpty
	}
	])) {
		return false;
	}
	return true;
}
