let urlParams = new URLSearchParams(window.location.search);
let userId = urlParams.get("userId");
if (userId == null || userId == '') {
	userId = localStorage.getItem('userId')
	if (userId == null || userId == '') {
		document.getElementById('createUser').value = true
	}
	else {
	window.location.href = '/?userId='+userId
	}
	}

if (userId != null && userId != '') {
	localStorage.setItem('userId', userId)
	document.getElementById('userId').value = userId
}



    let marsApiButtons = document.querySelectorAll("button[id*='marsApi']")
    marsApiButtons.forEach( button => button.addEventListener('click', function () {
    									const buttonId = this.id
    									const roverId = buttonId.split('marsApi')[1]
    									let apiData = document.getElementById('marsApiRoverData')
    									apiData.value = roverId
    									document.getElementById('frmRoverType').submit()
    								  }))

    //let marsRoverType = document.getElementById('marsApiRoverData').value
    let roverType = document.getElementById('marsApiRoverData').value
    let marsSol =  document.getElementById("marsSol").value
    if (marsSol != null){
    //marsSol = 1
    document.getElementById("marsSol").value = marsSol
    }


    for (let i = 0;i<marsApiButtons.length;i++){
        if (roverType == null){
            roverType = 'Opportunity'

        }
        if (marsApiButtons[i].innerHTML.toLowerCase() == roverType.toLowerCase()){
            marsApiButtons[i].classList.remove("btn-secondary");
            marsApiButtons[i].classList.add("btn-primary");
        } else{
            marsApiButtons[i].classList.add("btn-secondary");
            marsApiButtons[i].classList.remove("btn-primary");
        }
    }