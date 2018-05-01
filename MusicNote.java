public class MusicNote{
	private int time;
	private int channel;
	private String note;
	private int key;
	private int velocity;
	private boolean on;
	
	public MusicNote(int t, int c,  String n, int k, int v, boolean o){
		setTime(t);
		setChannel(c);
		setNote(n);
		setKey(k);
		setVelocity(v);
		setOnVal(o);
		
	}
	public int getTime(){
		return this.time;
		
	}
	public void setTime(int time){
		this.time = time;
	}
	
	
	
	public int getChannel(){
		return this.channel;
		
	}
	public void setChannel(int channel){
		if (channel>=0 && channel <17){
			this.channel = channel;
			
		}else{
			System.out.println("Channel Value invalid, channel set to 0");
			this.channel =0; 
			
		}
		
	}
	
	public String getNote(){
		return this.note;
		
	}
	public void setNote(String note){
		//Do more security checking but for now leave with no checks 
		
		this.note = note;
		
	}
	
	public int getKey(){
		return this.key;
		
	}
	
	public void setKey(int key){
		if(key>=0){
			this.key = key;
			
		}else{
			System.out.println("Key value invalid. Key set to 0");
			this.key = 0;
			
		}
	
	
	}
	
	public int getVelocity(){
		return this.velocity;
		
	}
	
	public void setVelocity(int velocity){
		if(velocity>=0){
			this.velocity = velocity;
			
		}else{
			System.out.println("Velocity value invalid. Velocity set to 0");
			this.velocity = 0;
			
		}
	}
	
	public boolean getOnVal(){
		return this.on;
		
	}
	public void setOnVal(boolean on){
		this.on  = on;
		
	}
	
	public String toString(){
		return "Note At: " + this.time + " Channel: " + this.channel + " is: " + this.note + " in key: " + this.key + " at volume: " + this.velocity + " the note on value is: " + this.on;
		
	}
	
}