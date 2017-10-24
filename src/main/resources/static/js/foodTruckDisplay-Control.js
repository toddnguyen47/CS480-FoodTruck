function loadJSON() {
	var jsonFile = $.getJSON("output.json", function(json) {
		var array1 = []
		for (let elem of json) {
			var tempDict = {};
			tempDict["id"] = elem["id"];
			tempDict["address"] = elem["location"];
			tempDict["latitude"] = elem["coordinates"]["latitude"];
			tempDict["longitude"] = elem["coordinates"]["longitude"];
			tempDict["phone_number"] = elem["phone"];
			tempDict["image_url"] = elem["image_url"];
			tempDict["url"] = elem["url"];
			array1.push(tempDict);
		}
		console.log(array1);
		document.getElementById("displayInfo").innerHTML = array1;
	});
}