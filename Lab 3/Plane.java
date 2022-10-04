package lab3;
public class Plane {

	private int numEmptySeat=12;
	private PlaneSeat[] seats = new PlaneSeat[12];
	private PlaneSeat[] newSeat = new PlaneSeat[12];
	Plane()
	{
		
	}
	public PlaneSeat[] sortSeats()
	{
		PlaneSeat[] temp = new PlaneSeat[12];
		int[] custTemp = new int[12-this.numEmptySeat];
		int count=0;
		for(int i =0;i<seats.length;i++)
		{
			if(seats[i]!=null && seats[i].isOccupied())
			{
					custTemp[count]=seats[i].getCustomerID();
					count++;
			}
		}
		count =0;
		
		for(int i=1;i<custTemp.length;++i)
		{
			int key = custTemp[i];
			int j=i-1;
			
			while(j>=0 && custTemp[j]>key)
			{
				custTemp[j+1]= custTemp[j];
				j = j-1;
			}
			custTemp[j+1] = key;
		}
		
		for(int i =0;i<custTemp.length;i++)
		{
			for(int j=0;j<seats.length;j++)
			{
				if(seats[j]!=null && custTemp[i]==seats[j].getCustomerID() && seats[j].isOccupied())
				{
					temp[count] = seats[j];
					count++;
					break;
				}

			}
		}
		return temp;
		
	}
	public void showNumEmptySeats()
	{
		int count=0;
		
		System.out.println("There are "+numEmptySeat+" empty seats");
	}
	public void showEmptySeats()
	{
		System.out.println("The following seats are empty: ");
		for(int i=0;i<seats.length;i++)
		{
			if(seats[i]==null||!seats[i].isOccupied())
			{
				System.out.println("SeatID "+(i+1));
			}
		}
	}
	public void showAssignedSeat(boolean bySeatId)
	{
		
		if(bySeatId)
		{
			System.out.println("The seat assignments are as follow: ");
			for(int i =0;i <seats.length;i++)
			{
				if(seats[i]!=null && seats[i].isOccupied())
				{
					System.out.println("SeatID "+(i+1)+" assigned to CustomerID "+seats[i].getCustomerID());
				}
			}
		}
		else
		{
			newSeat = sortSeats();
			System.out.println("The seat assignments are as follow : ");
			for(int i =0;i <newSeat.length;i++)
			{
				if(newSeat[i]!=null && newSeat[i].isOccupied())
				{
					System.out.println("SeatID "+newSeat[i].getSeatID()+" assigned to CustomerID "+newSeat[i].getCustomerID());
				}
			}
		}
	}
	public void assignSeat(int seatId, int cust_id)
	{
		int index =-1;
		for (int i=0; i < seats.length; i++)
        {
            if (seats[i] != null && seats[i].getSeatID() == seatId && seats[i].isOccupied())
                index = i;
        }
		if(index== -1||!seats[index].isOccupied())
		{
			PlaneSeat temp = new PlaneSeat(seatId);
			temp.assign(cust_id);
			seats[seatId-1]=temp;
			numEmptySeat--;
			System.out.println("Seat Assigned!\n");
		}
		else
		{
			System.out.println("Seat already assigned to a customer.");
		}
		
	}
	public void unAssignSeat(int seatId)
	{
			seats[seatId-1].unAssign();
			System.out.println("Seat unassigned!");
			numEmptySeat++;
	}
}
