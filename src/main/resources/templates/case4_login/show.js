function show() {
    $.ajax({
        type: "GET", url: "http://localhost:8080/accounts", //xử lý khi thành công
        success: function (data) {
            let str = "";

            for (let i = 0; i < data.length; i++) {
                str += `<tr>
<td>${data[i].id}</td>
<td>${data[i].usename}</td>
<td>${data[i].password}</td>
<td>${data[i].phone}</td>
<td>${data[i].email}</td>
<td>${data[i].birthday}</td>
<td>${data[i].address}</td>
<td>${data[i].identity}</td>
<td>${data[i].roles}</td>
<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1" onclick="Edit_Demo(${data[i].id})">EDIT</button></td>
<td><button type="button" class="btn btn-danger" onclick="delete_Demo(${data[i].id})">DELETE</button>
</tr>`
            }

            document.getElementById("tbody").innerHTML = str;
        }, error: function (err) {
            console.log(err)
        }
    })
}

show();


function Create() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let birthday = document.getElementById("birthday").value;
    let address = document.getElementById("address").value;
    let identity = document.getElementById("identity").value;
    let roles = document.getElementById("roles").value;


    let account = {

        username: username,password: password, phone: phone, email: email,birthday: birthday,address: address,identity: identity,roles:{id:roles}

    }

    $.ajax({
        type: "POST", headers: {
            'Accept': 'application/json', 'Content-Type': 'application/json'
        }, url: "http://localhost:8080/accounts", data: JSON.stringify(account), //xử lý khi thành công
        success: function (data) {
            show()
        }, error: function (err) {
            console.log(err)
        }
    })

    return show();
}


function Edit_Demo(id) {
    $.ajax({
        type: "PUT", headers: {
            'Accept': 'application/json', 'Content-Type': 'application/json'
        }
        , url: "http://localhost:8080/accounts/edit/" + id, //xử lý khi thành công
        success: function (data) {
            document.getElementById("id").value = data.id;
            document.getElementById("username1").value = data.username;
            document.getElementById("password1").value = data.password;
            document.getElementById("email1").value = data.email;
            document.getElementById("birthday1").value = data.birthday;
            document.getElementById("address1").value = data.address;
            document.getElementById("identity1").value = data.identity;
            document.getElementById("idRoles1").value = data.roles.id;
        }, error: function (err) {
            console.log(err)
        }
    })
}


function delete_Demo(id) {
    $.ajax({
        type: "Delete",
        headers: {
            'Accept': 'application/json', 'Content-Type': 'application/json'
        }, url: "http://localhost:8080/accounts/" + id,
        success: function (data) {
            show()
        }, error: function (err) {
            console.log(err)
        }
    })
}

function Edit() {
    let id = document.getElementById("id").value;

    let username = document.getElementById("username1").value;
    let password = document.getElementById("password1").value;
    let phone = document.getElementById("phone1").value;
    let email = document.getElementById("email1").value;
    let birthday = document.getElementById("birthday1").value;
    let address = document.getElementById("address1").value;
    let identity = document.getElementById("identity1").value;
    let roles = document.getElementById("roles").value;



    let account = {
        username: username,password: password, phone: phone, email: email,birthday: birthday,address: address,identity: identity,roles:{id:roles}
    }

    $.ajax({
        type: "POST", headers: {
            'Accept': 'application/json', 'Content-Type': 'application/json'
        }, url: "http://localhost:8080/accounts/edit", data: JSON.stringify(account),
        //xử lý khi thành công
        success: function (data) {
            show()
        }, error: function (err) {
            console.log(err)
        }
    })

    return show();
}



