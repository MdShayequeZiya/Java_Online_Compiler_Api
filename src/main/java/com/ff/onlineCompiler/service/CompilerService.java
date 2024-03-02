package com.ff.onlineCompiler.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class CompilerService {
	
	
	public String compileAndRun(String code) {
		try {
			// saving code in the temporary file
			
			
			System.err.println(code);
			
			String fileName = "TempFile.java";
			System.err.println("===============================");
			System.err.println(code);
			
			try(FileWriter writer = new FileWriter(fileName)){
				System.err.println("2");
				writer.write(code);
				
			}
			System.err.println("3");
			//using processbuilder to run javac and java code
			Process compilerProcess = new ProcessBuilder("javac", fileName).start();
			int compileExitCode = compilerProcess.waitFor();
			System.err.println("4");
			
			System.out.print(compileExitCode);
			
			if(compileExitCode == 0) {
				Process runProcess = new ProcessBuilder("java", "TempFile").start();
				
				System.err.println("5");
				StringBuilder executionResult = new StringBuilder();
				try(BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()))){
					String line;
					while((line = reader.readLine())!=null) {
						System.err.println("6");
						executionResult.append(line).append("\n");
					}
				}
				System.err.println("7");
				// wait for the process to complete
				int runExitCode = runProcess.waitFor();
				
				System.err.println(executionResult.toString());
				return "Execution Result: "+ (runExitCode == 0? executionResult.toString() : "RuntimeException");
			}else {
			    // Capture the error output of the compilation process
			    StringBuilder compilationError = new StringBuilder();
			    try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(compilerProcess.getErrorStream()))) {
			        String line;
			        while ((line = errorReader.readLine()) != null) {
			            compilationError.append(line).append("\n");
			        }
			    }

			    // Return the compilation error
			    return "Compilation Error:\n" + compilationError.toString();
			}
		
		}catch(IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
