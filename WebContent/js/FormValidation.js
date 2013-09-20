window.onload = init;
 
// The "onload" handler. Run after the page is fully loaded.
function init() {
   // Attach "onsubmit" handler
   document.getElementById("theForm").onsubmit = validateForm;
   // Attach "onclick" handler to "reset" button
   document.getElementById("reset").onclick = clearDisplay;
   // Set initial focus
   document.getElementById("name").focus();
   document.getElementById("introducedDate").focus();// Petu etre à enlever
   
}
 
/* The "onsubmit" handler to validate the input fields.
 * Most of the input validation functions take 2 arguments:
 * inputId or inputName: the "id" of the <input> element to be validated
 *   or "name" for checkboxes and radio buttons.
 * errorMsg: the error message to be displayed if validation fails.
 *   The message shall be displayed on an element with id of
 *   inputID+"Error" if it exists; otherwise via an alert().
 */
function validateForm() {
   return (isNotEmpty("name", "Please enter a computer name :)")
		&& isNotDate("introducedDate", "Please give us a correct date :)"));
		//&& isLengthMinMax("introduced", "Please respect the length of the date :)", 10, 10)
//		&& isLengthMinMax("discontinued", "Please respect the length of the date :)", 10, 10)
}
 
// Return true if the input value is not empty
function isNotEmpty(inputId, errorMsg) {
   var inputElement = document.getElementById(inputId);
   var errorElement = document.getElementById(inputId + "Error");
   var inputValue = inputElement.value.trim();
   var isValid = (inputValue.length != 0);  // boolean
   showMessage(isValid, inputElement, errorMsg, errorElement);
   return isValid;
}
 
/* If "isValid" is false, print the errorMsg; else, reset to normal display.
 * The errorMsg shall be displayed on errorElement if it exists;
 *   otherwise via an alert().
 */
function showMessage(isValid, inputElement, errorMsg, errorElement) {
   if (!isValid) {
      // Put up error message on errorElement or via alert()
      if (errorElement != null) {
         errorElement.innerHTML = errorMsg;
      } else {
         alert(errorMsg);
      }
      // Change "class" of inputElement, so that CSS displays differently
      if (inputElement != null) {
         inputElement.className = "error";
         inputElement.focus();
      }
   } else {
      // Reset to normal display
      if (errorElement != null) {
         errorElement.innerHTML = "";
      }
      if (inputElement != null) {
         inputElement.className = "";
      }
   }
}

//Return true if the given element is a date
function isNotDate(inputId, errorMsg) {
   var inputElement = document.getElementById(inputId);
   alert(inputElement);
   var errorElement = document.getElementById(inputId + "Error");
   var inputValue = inputElement.value.trim();
   thedate = inputValue.split('-');
   var year=thedate[0], month=thedate[1], day=thedate[2];
   
   if(year<1960||year>2050||month<1||month>12||day<1||day>31){
	   return false;
   }
   showMessage(isValid, inputElement, errorMsg, errorElement);
   return true;
}