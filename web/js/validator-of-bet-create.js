function validateBetCreate(form) {
	if(!validateForm(form, [{
		id: "betAmount",
		message: "Поле Размер ставки не заполнено",
		checker: checkNotEmpty
	}, {
		id: "rank",
		message: "Поле Предполагаемое место не заполнено",
		checker: checkNotEmpty
	}
	])) {
		return false;
	}
	return true;
}
