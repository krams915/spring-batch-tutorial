<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<c:url value="/users/records" var="recordsUrl"/>
<c:url value="/batch/job1" var="batchJob1Url"/>
<c:url value="/batch/job2" var="batchJob2Url"/>
<c:url value="/batch/job3" var="batchJob3Url"/>

<html>
<head>
	<link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/resources/css/style.css"/>'/>
	<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.6.4.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/js/custom.js"/>'></script>

	<title>User Records</title>
	
	<script type='text/javascript'>
	$(function() {
		// init
		urlHolder.records = '${recordsUrl}';
		loadTable();
		
		$('#firstJobBtn').click(function() { 
			$.get('${batchJob1Url}', function(response) {
				if (response.success == true) {
					alert('Job 1 imported');
				} else if (response.success == false) {
					alert(response.message[0]);
				}
			});
		});
		
		$('#secondJobBtn').click(function() { 
			$.get('${batchJob2Url}', function(response) {
				if (response.success == true) {
					alert('Job 2 imported');
				} else if (response.success == false) {
					alert(response.message[0]);
				}
			});
		});
		
		$('#thirdJobBtn').click(function() {
			$.get('${batchJob3Url}', function(response) {
				if (response.success == true) {
					alert('Job 3 imported');
				} else if (response.success == false) {
					alert(response.message[0]);
				}
			});
		});

		$('#resetBtn').click(function() {
		});
		
		$('#reloadBtn').click(function() {
			loadTable();
		});
		
	});
	</script>
</head>

<body>
	<h1 id='banner'>Record System</h1>
	<hr/>
	
	<table id='tableUsers'>
		<caption></caption>
		<thead>
			<tr>
				<th></th>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Role</th>
			</tr>
		</thead>
	</table>
	
	<div id='controlBar'>
		<input type='button' value='Import 1st Job' id='firstJobBtn' />
		<input type='button' value='Import 2nd Job' id='secondJobBtn' />
		<input type='button' value='Import 3rd Job' id='thirdJobBtn' />
		<input type='button' value='Reset' id='resetBtn' />
		<input type='button' value='Reload' id='reloadBtn' />
	</div>
	
</body>
</html>