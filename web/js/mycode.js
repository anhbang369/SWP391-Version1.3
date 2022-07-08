function ShowNotify(){
    if(document.getElementById('showValue').style.display === 'none'){
        document.getElementById('showValue').style.display = 'block';
    }else{
        document.getElementById('showValue').style.display = 'none';
    }
}

function ShowDateReceipt(){
    if(document.getElementById('showDateReceipt').style.display === 'none'){
        document.getElementById('showDateReceipt').style.display = 'block';
    }else{
        document.getElementById('showDateReceipt').style.display = 'none';
    }
}

function ShowDetailOrder(){
    if(document.getElementById('orderDetail').style.display === 'block'){
        document.getElementById('orderDetail').style.display = 'none';
    }else{
        document.getElementById('orderDetail').style.display = 'none';
    }
}
