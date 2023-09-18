
import java.util.HashMap;
import java.util.Scanner;

class Votes
{
    public String voter_name;
    public int voter_id;

    public int getVoter_id()
     {
        return voter_id;
     }
    public Votes(int voter_id)
     {
        this.voter_id = voter_id;
     }
    public Votes(String voter_name)
     {
        this.voter_name = voter_name;
     }
    public void setVoter_id(int voter_id) 
     {
        this.voter_id = voter_id;
     }

    public void setVoter_name(String voter_name)
     {
        this.voter_name = voter_name;
     }

    public String getVoter_name()
     {
        return voter_name;
     }

    public void printDetails()
     {
        System.out.println("user has voted with voter id "+voter_id);
     }
    @Override
    public String toString()
     {
        return super.toString();
     }
}

class Nominee
{
    public String nominee_name;
    public int nominee_id;

    public int getNominee_id()
     {
        return nominee_id;
     }
    public Nominee( int nominee_id) 
     {
        this.nominee_id = nominee_id;
     }
    public Nominee(String nominee_name)
     {
        this.nominee_name = nominee_name;
     }
    public void setNominee_id(int nominee_id) 
     {
        this.nominee_id = nominee_id;
     }

    public void setNominee_name(String nominee_name)
     {
        this.nominee_name = nominee_name;
     }

    public String getNominee_name() 
     {
        return nominee_name;
     }

    @Override
    public String toString() 
     {
        return super.toString();
     }
}

class Digital_Voting 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        HashMap<Nominee,Nominee> NomineeDetails = new HashMap<Nominee, Nominee>();
        HashMap<Votes,Integer> VoterDetails = new HashMap<Votes, Integer>();
        HashMap<Votes,Votes> UserDetails = new HashMap<Votes,Votes>();
        NomineeDetails.put(new Nominee(1),new Nominee("SHIVSENA"));
        NomineeDetails.put(new Nominee(2),new Nominee("BJP"));
        NomineeDetails.put(new Nominee(3),new Nominee("CONGRESS"));
        NomineeDetails.put(new Nominee(4),new Nominee("CPI"));
        System.out.println("Welcome to virtual voting");
        System.out.println("Pls enter no of voters");
        int voters = sc.nextInt();

        while (voters != 0)
         {
            System.out.println("enter last 4 digits of your aadhar");
            int VoterId = sc.nextInt();
            System.out.println("Enter voter name");
            String VoterName = sc.next();
            System.out.println("Choose whom to vote");
            System.out.println("for SHIVSENA enter 1");
            System.out.println("for BJP enter 2");
            System.out.println("for CONGRESS enter 3");
            System.out.println("for CPI enter 4");
            int NomineeId = sc.nextInt();
            Votes v = new Votes(VoterId);
            if(VoterDetails.keySet().contains(v)) 
              {
                System.out.println("You have already voted");
              }
            else
              {
                VoterDetails.put(new Votes(VoterId), NomineeId);
                UserDetails.put(new Votes(VoterId),new Votes(VoterName));
              }
            voters--;
         }
        int winners = 0;
        int ShivsenaVotes,BjpVotes,CongressVotes,CpiVotes;
        ShivsenaVotes=BjpVotes=CongressVotes=CpiVotes=0;
        System.out.println("Displaying SHIVSENA party voters: ");
        for (Votes key : VoterDetails.keySet()) 
        {
            if (VoterDetails.get(key).equals(1)) 
            {
                key.printDetails();
                ShivsenaVotes++;
            }
        }
        System.out.println("Displaying BJP party voters: ");
        for (Votes key : VoterDetails.keySet()) 
        {
            if (VoterDetails.get(key).equals(2))
             {
                key.printDetails();
                BjpVotes++;
            }
        }
        System.out.println("Displaying Congress party voters: ");
        for (Votes key : VoterDetails.keySet()) 
        {
            if (VoterDetails.get(key).equals(3)) 
            {
                key.printDetails();
                CongressVotes++;
            }
        }
        System.out.println("Displaying CPI party voters: ");
        for (Votes key : VoterDetails.keySet()) 
        {
            if (VoterDetails.get(key).equals(4))
             {
                key.printDetails();
                CpiVotes++;
             }
        }
        int max = (Math.max(ShivsenaVotes,Math.max(BjpVotes,Math.max(CongressVotes,CpiVotes))));
        if(ShivsenaVotes == max)
         {
            System.out.println("SHIVSENA has max votes");
            winners++;
         }
        if(BjpVotes == max)
         {
            System.out.println("BJP has max votes");
            winners++;
         }
        if(CongressVotes == max)
         {
            System.out.println("Congress has max votes");
            winners++;
         }
        if(CpiVotes == max)
         {
            System.out.println("Cpi has max votes");
            winners++;
         }
        if(winners>1)
         {
            System.out.println("Hence it is draw");
         }
    }
}