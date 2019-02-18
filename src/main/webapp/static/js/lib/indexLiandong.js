//初始化事件，获得所有省
function getProvince() {
	var oProvince = $("#province");
	for(var i = 0; i < areaJson.length; i++) {
		oProvince.append("<option value='" + areaJson[i].province + "'>" + areaJson[i].province + "</option>");
	}
}
/*点击省份事件------获取所有市*/
function getCity(proid, val) {
	console.log(proid,val);
	var oCity=$('#city');
	var oCounty=$('#county');
	if(val.indexOf('选择') >= 0) {   //如果选择的是      请选择
//		getProvince();		
		oCity.empty().append("<option value='请选择'>请选择</option>");
		oCounty.empty().append("<option value='请选择'>请选择</option>");
		return false;
	}
	firstId = proid;
	oCity.empty().append("<option value='请选择'>请选择</option>");
	oCounty.empty().append("<option value='请选择'>请选择</option>");
	console.log(areaJson[proid - 1].countyList.length);
	if(areaJson[proid - 1].countyList.length==0){  //如果城市的长度为空
		oCity.empty().append("<option value='请选择'>请选择</option>");
		oCounty.empty().append("<option value='请选择'>请选择</option>");
		return false;
	}
	for(var i = 0; i < areaJson[proid - 1].countyList.length; i++) {
		//console.log(areaJson[proid - 1].countyList[i].city);
		var cityData = areaJson[proid - 1].countyList[i].city;	
		oCity.append("<option value='" + cityData + "'>" + cityData + "</option>");
	}
}
/*根据省和市----获取县*/
function getCounty(cityId,val) {
	console.log(cityId,val);
	var oCounty=$('#county');
	if(val.indexOf('选择') >= 0) {   //如果选择的是      请选择
		oCounty.empty().append("<option value='请选择'>请选择</option>");
		return false;
	}
	secId = cityId;
	oCounty.empty().append("<option value='请选择'>请选择</option>");
	for(var i = 0; i < areaJson[firstId - 1].countyList[secId - 1].county.length; i++) {
		console.log(areaJson[firstId - 1].countyList[secId - 1].county[i].countyName);
		var countyData = areaJson[firstId - 1].countyList[secId - 1].county[i].countyName;
		oCounty.append("<option value='" + countyData + "'>" + countyData + "</option>");
 
	}
 
}
