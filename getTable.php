<?PHP 
	
	$con = mysqli_connect("mysql9.000webhost.com", "a7068193_user", "c0ding", "a7068193_mmlogin");
    
    $statement = mysqli_query($con, "SELECT * FROM event");

    $num_rows = mysqli_num_rows($statement);
    while($row = mysqli_fetch_array($statement))
    {
    	$r[] = $row;
    	$check=$row['user_id'];
    }

    if($check == NULL)
    {
    	$r[$num_rows]="Yo table is empty";
    	print(json_encode($r));
    }
    else
    {
    	$r[$num_rows] = "success";
    	print(json_encode($r));
    }
?>