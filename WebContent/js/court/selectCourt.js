function yeshu(cp){
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}
	function fenyebycourt(courtcode){
		document.getElementById("courtcode").value=courtcode;
		document.getElementById("fenye").submit();
	}
	function loadCalendar(field)
	{
		if(navigator.userAgent.indexOf("Chrome") >0 ){
			var winOption = "height=250px,width=320px,status:no;help:no;scrolling=no;scrollbars=no";
    		window.open("/lawyer/user/source/calender.jsp","", winOption);
		}else{
			var rtn=window.showModalDialog("/lawyer/user/source/calender.jsp","","dialogWidth:320px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null){
				field.value=rtn;
			}
		}
		return;
	}
	
	function resultopt(){
		var executestep = document.getElementById("step").value;
	//	var status = document.getElementById("status").value;
		
		if(executestep==""){
			alert("��ѡ��Դ��ǰִ�в���!");
			return;
		}
		/* if(status==""){
			alert("��ѡ����ҵ״̬!");
			return;
		} */

		if(executestep=="2"||executestep=="4"||executestep=="5"){
			alert("���޲���!");
			return;
		}
		var mes = "";
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="����ʱ���,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"�Ժ�,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"��ǰ,";
		}else{
				mes="ʱ���"+strTimeEvection+"��"+endTimeEvection+"�ڼ�,";
		}
		mes+="��ǰ����Ϊ \"";
		if(executestep=="1"){
			mes+="��ִ����ִ����Ϣ";
		}else if(executestep=="2"){
			mes+="��ִ������ҵ��Ϣ";
		}else if(executestep=="3"){
			mes+="����ִ������ҵ��Ϣ";
		}else if(executestep=="4"){
			mes+="����ִ����������Ϣ";
		}else if(executestep=="5"){
			mes+="����ִ����������Ϣ";
		}
		mes+="\"��";
		var courtcode = document.getElementById("courtcode").value;//��Ժ���
		if(courtcode==""){
			mes+="���а�Դ,";
		}else{
			mes+="���Ϊ"+courtcode+"��Ժ�����а�Դ,";
		}
		mes+="����ϵͳ�����ļ�,�Ƿ����?";
		//���ʱ��
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//ִ�б��
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/createData.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//�ı䰸Դ��Ϣ��ִ�в���
	function changeStep(){
		var executestep = document.getElementById("step").value;
		var courtStep = document.getElementById("courtStep").value;
		if(executestep==""){
			alert("��ѡ��Դ��ǰִ�в���!");
			return;
		}
		if(courtStep==""){
			alert("��дҪ�ı��ִ�в���!");
			return;
		}
		var mes = "";
		var courtcode = document.getElementById("courtcode").value;//��Ժ���
		var strTimeEvection = document.getElementById("strTimeEvection").value;
		var endTimeEvection = document.getElementById("endTimeEvection").value;
		if(strTimeEvection=="" && endTimeEvection==""){
				mes="����ʱ���,";
		}else if(strTimeEvection!="" && endTimeEvection==""){
				mes=strTimeEvection+"�Ժ�,";
		}else if(endTimeEvection!="" && strTimeEvection==""){
				mes=endTimeEvection+"��ǰ,";
		}else{
				mes="ʱ���"+strTimeEvection+"��"+endTimeEvection+"�ڼ�,";
		}	
		mes="���ı�����ѯ�����ݵ�ִ�в��裬�Ƿ����?";
		//���ʱ��
		var instrTimeEvection=document.getElementById("instrTimeEvection").value;
		var inendTimeEvection = document.getElementById("inendTimeEvection").value;
		//ִ�б��
		var minMoney = document.getElementById("minMoney").value;
		var maxMoney = document.getElementById("maxMoney").value;
		
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/changeCourtStep.action",
				data:"court.courtcode="+courtcode+"&court.executestep="+executestep+"&startDate="+strTimeEvection+"&endDate="+endTimeEvection+"&instartDate="+instrTimeEvection+"&inendDate="+inendTimeEvection+"&minMoney="+minMoney+"&maxMoney="+maxMoney+"&courtStep="+courtStep,
				success:function(msg){
					alert(msg);
				}
			});
		}
	}

	//������һ�����
	function Run() 
	{ 
		alert("��Ǹ�����ֶ�������ʹ�õ����");
	}  
	//��ִ����ִ����Ϣ������
	function insertCourts(){
		var mes = "ȷ�����б�ִ����ִ����Ϣ���������� ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertCourts.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//��ִ���˹�����Ϣ
	function insertNoteCourts(){
		var mes = "ȷ�����б�ִ���ˣ�ծ���ˣ�������Ϣ��������� ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertNoteCourts.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//��ִ������ҵ��Ϣ������
	function insertEbs(){
		var mes = "ȷ�����б�ִ������ҵ��Ϣ���������� ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertExecutes.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	
	//����ִ������ҵ��Ϣ
	function insertApplierinfos(){
		var mes = "ȷ����������ִ������ҵ��Ϣ���������� ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertApplierinfos.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	//����ִ������ҵ������Ϣ
	function insertApplierinfoNets(){
		var mes = "ȷ����������ִ������ҵ������Ϣ���������� ";
		if(confirm(mes)){
			$.ajax({
				type:"POST",
				cache:false,
				url:"/lawyer/insertAppNets.action",
				success:function(msg){
					alert(msg);
				}
			});
		}
	}
	function tiao(){
		var cp = document.getElementById("tiaoye").value;
		if(isNaN(cp)){
			alert("��������ȷ���֣�");
			return;
		}
		document.getElementById("cp").value=cp;
		document.getElementById("fenye").submit();
	}