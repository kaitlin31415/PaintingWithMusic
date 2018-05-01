import java.io.File;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import java.util.ArrayList;

public class DataGrabber {
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	
	
	
    public static void main(String[] args) throws Exception {
		ArrayList<MusicNote> notes = new ArrayList<MusicNote>();
        Sequence sequence = MidiSystem.getSequence(new File("twinkle_twinkle.mid"));

        int trackNumber = 0;
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());
            System.out.println();
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
				String timeStamp = "" +  event.getTick();

                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
					String channel  ="" +sm.getChannel();

					
					
                    if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();

						MusicNote curr = new MusicNote(Integer.parseInt(timeStamp), Integer.parseInt(channel), noteName + octave , key, velocity, true);
						notes.add(curr);
						
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
						MusicNote curr = new MusicNote(Integer.parseInt(timeStamp), Integer.parseInt(channel), noteName + octave , key, velocity, false);
						notes.add(curr);
                    } else {

                    }
                } else {
                }
            }

            System.out.println();
        }
		
		for (int i = 0; i <10; i++){
			System.out.println(notes.get(i));
			
		}

    }
}