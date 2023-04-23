 

 public abstract class BasePerson {

	protected String name;
	private boolean publish;
	private int age;
	private int id;
	
		public BasePerson(String name,int age, boolean pub)
		{
			this.name =name;
			this.age=age;
			 publish = pub;
		}
		
		public int getAge()
		{
			return age;
		}
		

		public abstract String getName();
		
		protected void setId(int id)
		{
		   this.id = id; 
		  }
		
				
		public int getId()
		{
			return id;
		}
		
		public boolean getPublish()
		{
			return publish;
		}
		
} 
