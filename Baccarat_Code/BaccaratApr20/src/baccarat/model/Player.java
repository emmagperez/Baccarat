package baccarat.model;

public class Player {
	
	int totalWins;
	int totalLosses;
	int totalTies;
	int totalGames;

	//Below are "get" methods for total values
		
	public int getTotalWins()
	{
		return totalWins;
	}
	
	public int getTotalLosses()
	{
		return totalLosses;
	}
	
	public int getTotalTies()
	{
		return totalTies;
	}
	
	public int getTotalGames()
	{
		return totalGames;
	}
	
	//Below are "get" methods for total CURRENT values
	
	public int setTotalWins(int n)
	{
		this.totalWins = n;
		return totalWins;
	}
	
	public int setTotalLosses(int n)
	{
		this.totalLosses = n;
		return totalLosses;
	}
	
	public int setTotalTies(int n)
	{
		this.totalTies = n;
		return totalTies;
	}
	
	public int setTotalGames(int n)
	{
		this.totalGames = n;
		return totalGames;
	}
}
