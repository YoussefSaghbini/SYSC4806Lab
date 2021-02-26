$(document).ready(function() {

    $("#ajaxGet").click(function(){
        ajaxGet();
    });

    $("#ajaxPost").click(function(){
        ajaxPost();
        ajaxGet();
    });
});

// GET REQUEST
function ajaxGet() {
    $.ajax(
        {
            type: 'GET',
            url: '/size',
        })
        .then(function (data){
            $('#ajaxTable > tbody').empty();
            var html = '';
            $.each(data, function(result){ // Addressbook
                html += "<tr>\n" + "<td>" + (result+1) + "</td>\n"+"<td>\n <table>"
                    + "<tr> <th>BuddyInfo ID</th> <th>BuddyInfo Name</th> <th>BuddyInfo Number</th> </tr>";
                var index = 0;
                for(index = 0; index < data[result].buddyList.length; index++) { // Buddies
                    if(data[result] != null) {
                        if(data[result].buddyList != null) {
                            var subObj = data[result].buddyList[index];
                            html += '<tr>';
                            html += '<td>' + subObj.id + '</td>';
                            html += '<td>' + subObj.name + '</td>';
                            html += '<td>' + subObj.phoneNumber + '</td>';
                            html += '</tr>';
                        }
                    }
                }
                html+="</table> "
            })
            html+= "</td>\n" + "</tr>";

            $("#ajaxTable").append(html);


        });
}

//POST Request
function ajaxPost(){

    var buddyInfo = {
        addressID: parseInt($("#addressID").val()),
        name: $("#name").val(),
        phoneNumber: $("#phoneNumber").val()
    }
    console.log(buddyInfo)
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/buddyadd-ajax",
        data: JSON.stringify(buddyInfo),
        dataType: 'json',
        success: function (result) {
            if (result.status === "OK") {
                alert("Form was successfully sent!")
            }else{
                console.log(result);
            }
        },
        error : function(e) {
            alert("Error - Form Submission Failed")
            console.log("ERROR: ", e);
        }
    });
}
