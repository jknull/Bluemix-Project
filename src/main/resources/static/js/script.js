function initMap() {
	var latitude=document.getElementById('longi').innerHTML;
	   var longitude=document.getElementById('latitude').innerHTML;
    var uluru = {lat: parseFloat(latitude), lng: parseFloat(longitude)};
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 4,
      center: uluru
    });
    var marker = new google.maps.Marker({
      position: uluru,
      map: map
    });
  }
