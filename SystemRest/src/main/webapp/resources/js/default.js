$(function() {
    var systemMonitor = {
        memoryState: [],
        lastCheckTime: -1
    };

    $.ajax({
        url: 'http://localhost:8080/rest/memory/',
        dataType : "json",
        success: function (data, textStatus) {
            $.each(data, function(i, val) {
                systemMonitor.memoryState.push([i, val.freeSpace]);
            });
            systemMonitor.memorySize = data[0].fullSpace;
            systemMonitor.lastCheckTime = data[data.length - 1].checkTime;
            var plot = $.plot("#memory-flot", [ systemMonitor.memoryState ], {
                series: {
                    shadowSize: 0	// Drawing is faster without shadows
                },
                yaxis: {
                    min: 0,
                    max: systemMonitor.memorySize
                },
                xaxis: {
                    show: false
                }
            });
            setInterval(function(){
                $.ajax({
                    url: 'http://localhost:8080/rest/memory/last',
                    dataType : "json",
                    success: function (data, textStatus) {
                        if(data.checkTime !== systemMonitor.lastCheckTime){
                            systemMonitor.memoryState.splice(0, 1);
                            systemMonitor.memoryState.push([data.checkTime, data.freeSpace]);
                            $.each(systemMonitor.memoryState, function(i, val) {
                                val[0] = i;
                            });
                            plot.setData([systemMonitor.memoryState]);
                            plot.draw();
                        }

                    }
                });
            }, 1000)
        }
    });
});