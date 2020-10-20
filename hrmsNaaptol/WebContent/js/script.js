var validate = new validation();

function validation()
{
	this.check = check;
	this.checkEmpty = checkEmpty;
	this.checkPasswordREg=checkPasswordREg;
	this.checkEmptyRegister=checkEmptyRegister;
	this.nameReg=nameReg;
	this.ValidateDOB=ValidateDOB;
	this.mobileReg=mobileReg;
	this.addressReg = addressReg;
	this.pincodeReg =pincodeReg;
	this.passwordReg=passwordReg;
	this.confirmPasswordValidate =confirmPasswordValidate;
	this.lettersOnly = lettersOnly;
	this.checker = checker;
	this.regex= regex;
	this.checkRegister=checkRegister;
	this.valiadeLogin=valiadeLogin;
	this.getEmpInfo = getEmpInfo;
	this.getInOutTime=getInOutTime;
	this.setDateShiftinOut =setDateShiftinOut;
	this.getUserInfo=getUserInfo;
	this.getUserLeave=getUserLeave;
	this.issueBook=issueBook;
	
	function checker(obj,msgLabel)
	{
		checkEmptyRegister(obj,msgLabel);
		regex(obj,msgLabel);
		
	}
	
	function regex(obj,msgLabel)
	{
		if(msgLabel == 'lblFirstName' || msgLabel == 'lblLastName')
		{nameReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblDob')
		{
			ValidateDOB(obj,msgLabel);
		}
		else if(msgLabel=='lblMobileNo')
		{
			mobileReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblAddress')
		{
			addressReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblPincode')
		{
			pincodeReg(obj,msgLabel);
		}
		
		
	}
	
	function check()
	{
		var name = document.getElementById('user')
		var password = document.getElementById('logingPassword')
		var form = document.getElementById('form')
		var errorElement = document.getElementById('error')
		var passReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;

	form.addEventListener('submit', (e) => 
	{
	 var messages = [];
	  if (name.value === '' || name.value == null) 
	  {
		messages.push('Name is required')
       errorElement.innerText = messages;
		document.getElementById("error").style.color = "red";
		document.getElementById("error").style.border = "red";
		document.getElementById("error").style.backgroundColor = "pink";
		document.getElementById("error").style.padding = "10px";
		document.getElementById("error").style.margin = "10px";
	}

  if (password.value.length <= 8) 
  {
    messages.push('Password must be longer than 8 characters')
  }

  if (password.value.length >= 20) 
  {
    messages.push('Password must be less than 20 characters')
  }

  if (password.value === 'password') 
  {
    messages.push('Password cannot be password')
  }
  if(passReg.test(password)) 
  {	
	messages.push('password invalid')
  }
	

  if (messages.length > 0) 
  {
    e.preventDefault()
    errorElement.innerText = messages.join(', ')
  }
})
	}

	function checkEmpty(obj , msgLabel)
	{
		
        var messages = [];
		var emptycheck = document.getElementById(obj).value;
		var errorElement = document.getElementById('error')
		
		if(emptycheck == null || emptycheck === ''   )
		{
		messages.push('user name or password is empty')
		document.getElementById("error").style.color = "red";
		document.getElementById("error").style.border = "red";
		document.getElementById("error").style.backgroundColor = "pink";
		document.getElementById("error").style.padding = "10px";
		document.getElementById("error").style.margin = "10px";
		errorElement.innerText = messages.join(', ')
		
		return false;
		
		}
		
		
		else
		{
			document.getElementById("error").innerHTML="";
			return true;
		}
		
	}
	
	function checkPasswordREg(obj,msgLabel)
	{
		var messages = [];
		var pass=document.getElementById(obj).value;
		var errorElement = document.getElementById('error')
		var passwReg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
		
			if(passwReg.test(pass)) 
			{ 
			messages.push('password correct')
			errorElement.innerText = messages.join(', ')
			return true;
			}
			else
			{ 
			messages.push('password incorrect')
			errorElement.innerText = messages.join(', ')
			
			return false;
			} 
			
	}
	
	function valiadeLogin(obj,msgLabel)
	{	
		checkEmpty(obj , msgLabel);
		checkPasswordREg(obj,msgLabel);
		
	}
	
	function checkEmptyRegister(obj,msgLabel)
	{
		var empty = document.getElementById(obj).value;
		if(empty === '' || empty == null )
		{
			document.getElementById(msgLabel).innerText ="* this field is required";
			return false;
		}
		else
		{
			document.getElementById(msgLabel).innerText = "";
			return true; 
		}
		
		
	}
	
	function nameReg(obj,msgLabel)
	{
		var letters = /^([A-z])+$/;
		
		if(letters.test(obj.value))
		{
		document.getElementById(msgLabel).innerText += "";
		return true;
		}
		else
		{
		document.getElementById(msgLabel).innerText ='*Username must have alphabet characters only';
		return false;
		} 
		
	}
	
	function ValidateDOB(obj,msgLabel)
	{
        var lblError = document.getElementById(msgLabel);
 
        
        var dateString = document.getElementById(obj).value;
        var regex = /(((19|20)\d\d)\-(0[1-9]|1[0-2])\-((0|1)[0-9]|2[0-9]|3[0-1]))$/;
 
       
        if (regex.test(dateString)) {
            var parts = dateString.split("-");
            var dtDOB = new Date(parts[1] + "-" + parts[2] + "-" + parts[0]);
            var dtCurrent = new Date();
            lblError.innerHTML = "Eligibility 18 years ONLY."
            if (dtCurrent.getFullYear() - dtDOB.getFullYear() < 18) {
                return false;
            }
 
            if (dtCurrent.getFullYear() - dtDOB.getFullYear() == 18) {
 
               
                if (dtCurrent.getMonth() < dtDOB.getMonth()) {
                    return false;
                }
                if (dtCurrent.getMonth() == dtDOB.getMonth()) {

                    if (dtCurrent.getDate() < dtDOB.getDate()) {
                        return false;
                    }
                }
            }
            lblError.innerHTML = "";
            return true;
        } else {
            lblError.innerHTML = "Enter date in dd/MM/yyyy format ONLY."
            return false;
        }
	}
	
	
			function mobileReg(obj,msgLabel)
			{
				var mobilereg = /[7-9][1-9]{9}/;
				var mobile = document.getElementById(obj).value;
				var lblError = document.getElementById(msgLabel);
				if(mobilereg.test(mobile))
				{
				lblError.innerHTML = "";
				return true;
				}
				else
				{
				lblError.innerHTML ='*Invalid mobile no';
				return false;
				}
				
			}
			function addressReg(obj,msgLabel)
			{
				var addressReg = /^[0-9a-zA-Z]+$/;
				var address = document.getElementById(obj).value;
				var lblError = document.getElementById(msgLabel);
				if(addressReg.test(address))
				{
				lblError.innerHTML = "";
				return true;
				}
				else
				{
				lblError.innerHTML ='*User address must have alphanumeric characters only';
				return false;
				}
			}
			
			function pincodeReg(obj,msgLabel)
			{
				var numbers = /^[0-9]+$/;
				var pincode = document.getElementById(obj).value;
				var lblError = document.getElementById(msgLabel);
				if(numbers.test(pincode))
				{
				lblError.innerHTML = "";
				return true;
				}
				else
				{
				lblError.innerHTML ='*Pincode code must have numeric characters only';
				return false;
				}
			}
			
			function passwordReg(obj,msgLabel)
			{
				var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
				var pass = document.getElementById(obj).value;
				var lblError = document.getElementById(msgLabel);
				if(reg.test(pass))
				{
				lblError.innerHTML ="";
				return true;
				}
				else
				{
				lblError.innerHTML ='* password invalid please try again';
				return false;
				}
			}
			
			function confirmPasswordValidate()
			{
				var pass =  document.getElementById('pass').value;
				var confirmpass= document.getElementById('confirmpass').value;
				if (pass != confirmpass) 
				{
				document.getElementById('lblConfirmPass').innerHTML="*Passwords do not match.";
				return false;
				}
				else
				{
				document.getElementById('lblConfirmPass').innerHTML="";
				return true;
				}
			}
			
			function lettersOnly() 
			{
            var charCode = event.keyCode;

            if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || charCode == 8)

                return true;
            else
                return false;
			}
			
			function checkRegister()
			{
				
				var fname=document.getElementById("fname").value;
				var lname=document.getElementById("lname").value;
				var dateofbirth = document.getElementById("dateofbirth").value;
				var dateofjoining = document.getElementById("dateofjoining").value;
				var dept=document.getElementById("dept").value;
				var roll=document.getElementById("roll").value;
				var mobileno = document.getElementById("mobileno").value;
				var pass = document.getElementById("pass").value;
				var confirmpass=document.getElementById("confirmpass").value;
				var state = document.getElementById("state").value;
				var city = document.getElementById("city").value;
				var address = document.getElementById("address").value;
				var pincode = document.getElementById("pincode").value;
				
			if(fname == "" || fname == null)
			{
				document.getElementById("lblFirstName").innerHTML = "*this filed is required";
				document.getElementById("lblFirstName").style.color ="red";
				return false;
			}
			else if(lname == "" || lname == null)
			{
				document.getElementById("lblLastName").innerHTML = "*this filed is required";
				document.getElementById("lblLastName").style.color ="red";
				return false;
			}
			else if(dateofbirth == "" || dateofbirth == null)
			{
				document.getElementById("lblDob").innerHTML = "*this filed is required";
				document.getElementById("lblDob").style.color ="red";
				return false;
			}
			else if(dateofjoining == "" || dateofjoining == null)
			{
				document.getElementById("lblDoj").innerHTML = "*this filed is required";
				document.getElementById("lblDoj").style.color ="red";
				return false;
			}
			else if(fname == "" || fname == null)
			{
				document.getElementById("dept").innerHTML = "*this filed is required";
				document.getElementById("dept").style.color ="red";
				return false;
			}
			else if(dept == "" || dept == null)
			{
				document.getElementById("lblDept").innerHTML = "*this filed is required";
				document.getElementById("lblDept").style.color ="red";
				return false;
			}
			else if(roll == "" || roll == null)
			{
				document.getElementById("lblRoll").innerHTML = "*this filed is required";
				document.getElementById("lblRoll").style.color ="red";
				return false;
			}
			else if(mobileno == "" || mobileno == null)
			{
				document.getElementById("lblMobileNo").innerHTML = "*this filed is required";
				document.getElementById("lblMobileNo").style.color ="red";
				return false;
			}
			else if(pass == "" || pass == null)
			{
				document.getElementById("lblPass").innerHTML = "*this filed is required";
				document.getElementById("lblPass").style.color ="red";
				return false;
			}
			else if(confirmpass == "" || confirmpass == null)
			{
				document.getElementById("lblConfirmPass").innerHTML = "*this filed is required";
				document.getElementById("lblConfirmPass").style.color ="red";
				return false;
			}
			else if(state == "" || state == null)
			{
				document.getElementById("lblState").innerHTML = "*this filed is required";
				document.getElementById("lblState").style.color ="red";
				return false;
			}
			else if(city == "" || city == null)
			{
				document.getElementById("lblCity").innerHTML = "*this filed is required";
				document.getElementById("lblCity").style.color ="red";
				return false;
			}
			else if(address == "" || address == null)
			{
				document.getElementById("lblAddress").innerHTML = "*this filed is required";
				document.getElementById("lblAddress").style.color ="red";
				return false;
			}
			else if(pincode == "" || pincode == null)
			{
				document.getElementById("lblPincode").innerHTML = "*this filed is required";
				document.getElementById("lblPincode").style.color ="red";
				return false;
			}
				

			}
			
			function getEmpInfo()
			{
				alert("hiiii");
				var contextPath = $('#contextPath').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"displayEmployee"},
					    function(data)
					    {
					    	alert(data);
					    	var s =console.log(data);
					    	var parseData = $.parseJSON(data.trim());
					    	alert(parseData);
					    	var length = parseData.length;
					    	var table_body  = '<table border="1" style="margin:auto;font-size:20px; border-color:white">';
					    	table_body+=' <tr><td>EmployeeId</td><td>First Name</td><td>Last Name</td><td>Date of Birth</td><td>Joining Date</td><td>Department</td><td>Roll</td><td>Mobile No</td><td>State</td><td>City</td><td>Address</td><td>Pincode</td><td>Action</td></tr>';
			    		 	
					    	for(var i=0; i<length;i++)
					    		{
					    		table_body+='<tr><td>'+parseData[i].pkempid+'</td><td>'+parseData[i].fname+'</td><td>'+parseData[i].lname+'</td><td>'+parseData[i].dob+'</td><td>'+parseData[i].doj+'</td><td>'+parseData[i].department+'</td><td>'+parseData[i].roll+'</td><td>'+parseData[i].mobileno+'</td><td>'+parseData[i].state+'</td><td>'+parseData[i].city+'</td><td>'+parseData[i].address+'</td><td>'+parseData[i].pincode+'</td><td><a href="/hrmsNaaptol/jsp/updateEmployeeInfo.jsp?empid='+parseData[i].pkempid+'">UPDATE</a></td></tr>';	
					    		}
					    	table_body+='</table>';
					    	$('#showEmployeeData').html(table_body);
					          alert("parseData");
					    });
					 
			}
			
			function getUserInfo()
			{
				
				var contextPath = $('#contextPath').val();
				var empid = $('#empid').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"displayUserInfo",empid:empid},
					    function(data)
					    {
					    	
					    	var s =console.log(data);
					    	var parseData = $.parseJSON(data.trim());
					    	var length = parseData.length;
					    	var table_body  = '<table border="1" style="margin:auto;font-size:20px; border-color:white">';
					    	table_body+=' <tr><td>EmployeeId</td><td>First Name</td><td>Last Name</td><td>Date of Birth</td><td>Joining Date</td><td>Department</td><td>Roll</td><td>Mobile No</td><td>State</td><td>City</td><td>Address</td><td>Pincode</td></tr>';
			    		 	
					    	for(var i=0; i<length;i++)
					    		{
					    		table_body+='<tr><td>'+parseData[i].pkempid+'</td><td>'+parseData[i].fname+'</td><td>'+parseData[i].lname+'</td><td>'+parseData[i].dob+'</td><td>'+parseData[i].doj+'</td><td>'+parseData[i].department+'</td><td>'+parseData[i].roll+'</td><td>'+parseData[i].mobileno+'</td><td>'+parseData[i].state+'</td><td>'+parseData[i].city+'</td><td>'+parseData[i].address+'</td><td>'+parseData[i].pincode+'</td></tr>';	
					    		}
					    	table_body+='</table>';
					    	$('#showUserData').html(table_body);
					         
					    });
				
			}
			
			function getUserLeave()
			{
				var contextPath = $('#contextPath').val();
				var empid = $('#empid').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"displayUserLeave",empid:empid},
					    function(data)
					    {
					    	alert(data);
					    	var s =console.log(data);
					    	var parseData = $.parseJSON(data.trim());
					    	var length = parseData.length;
					    	var table_body  = '<table border="1" style="margin:auto;font-size:20px; border-color:white">';
					    	table_body+=' <tr><td>EmployeeId</td><td>Description</td><td>From Date</td><td>To Date</td><td>Status</td></tr>';
			    		 	
					    	for(var i=0; i<length;i++)
					    		{
					    		table_body+='<tr><td>'+parseData[i].empid+'</td><td>'+parseData[i].description+'</td><td>'+parseData[i].fromDate+'</td><td>'+parseData[i].toDate+'</td><td>'+parseData[i].action+'</td></tr>';	
					    		}
					    	table_body+='</table>';
					    	$('#showUserLeave').html(table_body);
					         
					    });
			}
			
			
			function getInOutTime()
			{
				var contextPath = $('#contextPath').val();
				var empid = $('#empid').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"getInOutTime",empid:empid},
					    function(data)
					    {
					    	location.reload();
					    	
					    });
				
			}
			
			function setDateShiftinOut()
			{
				var contextPath = $('#contextPath').val();
				var empid = $('#empid').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"setDateInOutTime",empid:empid},
					    function(data)
					    {
					    	location.reload();
					    	
					    });
				
			}
			
			function issueBook()
			{
				var contextPath = $('#contextPath').val();
				var bname = $('#bname').val();
				var desc = $('#desc').val();
				var aFname = $('#aFname').val();
				var aLname = $('#aLname').val();
				$.post(contextPath+"/ajax/ajaxController.jsp",
					    {action:"issueBook",bname:bname,desc:desc,aFname:aFname,aLname:aLname},
					    function(data)
					    {
					    	location.reload();
					    	
					    });
				
			}
			
			
			
	
}