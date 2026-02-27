let processes = [];

function addProcess() {
    let pid = document.getElementById("pid").value;
    let at = parseInt(document.getElementById("at").value);
    let bt = parseInt(document.getElementById("bt").value);

    if (pid === "" || isNaN(at) || isNaN(bt)) {
        alert("Fill all fields");
        return;
    }

    processes.push({
        pid: pid,
        at: at,
        bt: bt,
        remaining: bt,
        ct: 0
    });

    let table = document.getElementById("processTable");
    let row = table.insertRow();
    row.insertCell(0).innerText = pid;
    row.insertCell(1).innerText = at;
    row.insertCell(2).innerText = bt;
}

function calculateRR() {
    let quantum = parseInt(document.getElementById("quantum").value);
    if (isNaN(quantum)) {
        alert("Enter Time Quantum");
        return;
    }

    let time = 0;
    let queue = [];
    let gantt = document.getElementById("gantt");
    gantt.innerHTML = "";

    processes.sort((a, b) => a.at - b.at);
    queue.push(...processes.filter(p => p.at === 0));

    let completed = 0;

    while (completed < processes.length) {
        if (queue.length === 0) {
            time++;
            queue.push(...processes.filter(p => p.at === time));
            continue;
        }

        let p = queue.shift();
        let execTime = Math.min(quantum, p.remaining);

        p.remaining -= execTime;
        time += execTime;

        // let block = document.createElement("div");
        // block.className = "block";
        // block.innerText = p.pid;
        // gantt.appendChild(block);
        let startTime = time - execTime;
        let endTime = time;

        let ganttBlock = document.createElement("div");
        ganttBlock.className = "gantt-block";

        let bar = document.createElement("div");
        bar.className = "bar";
        bar.innerText = p.pid;

        let timeLabel = document.createElement("div");
        timeLabel.className = "time";
        timeLabel.innerText = `${startTime} - ${endTime}`;

        ganttBlock.appendChild(bar);
        ganttBlock.appendChild(timeLabel);
        gantt.appendChild(ganttBlock);
        queue.push(...processes.filter(
            x => x.at > time - execTime && x.at <= time && x.remaining > 0
        ));

        if (p.remaining > 0) {
            queue.push(p);
        } else {
            p.ct = time;
            completed++;
        }
    }

    showResults();
}

function showResults() {
    let table = document.getElementById("resultTable");
    table.innerHTML = `
        <tr>
            <th>PID</th>
            <th>CT</th>
            <th>TAT</th>
            <th>WT</th>
        </tr>
    `;

    let totalWT = 0, totalTAT = 0;

    processes.forEach(p => {
        let tat = p.ct - p.at;
        let wt = tat - p.bt;
        totalWT += wt;
        totalTAT += tat;

        let row = table.insertRow();
        row.insertCell(0).innerText = p.pid;
        row.insertCell(1).innerText = p.ct;
        row.insertCell(2).innerText = tat;
        row.insertCell(3).innerText = wt;
    });

    document.getElementById("average").innerText =
        `Average TAT = ${(totalTAT / processes.length).toFixed(2)}, 
         Average WT = ${(totalWT / processes.length).toFixed(2)}`;
}